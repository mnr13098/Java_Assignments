package com.example.springBatchDemo.config;
import com.example.springBatchDemo.Repository.OrdersRepository;

import java.util.logging.Logger;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;


import com.example.springBatchDemo.entity.Orders;

@Configuration

public class BatchConfig {
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	Logger logger = Logger.getLogger("BatchConfig");
	
	@Bean
	FlatFileItemReader<Orders> reader() {
		FlatFileItemReader<Orders> fileReader = new FlatFileItemReader<>();
		fileReader.setStrict(false);
		
		logger.info("Created FlatFileItemReader object");
		
		// Specify csv path
		fileReader.setResource(new FileSystemResource("src/main/resources/Orders 1.csv"));
		logger.info("Configured resource path");
		
		// set name to fileReader
		fileReader.setName("csvReader");
		
		// Ignore header from csv
		fileReader.setLinesToSkip(1);
		
		// define Line mapper - maps each line in csv to java obj
		fileReader.setLineMapper(lineMapper());

		return fileReader;
	}
	
	private LineMapper<Orders> lineMapper() {

		// Create Line mapper object
		DefaultLineMapper<Orders> lineMapper = new DefaultLineMapper<>();

		// LineTokenizer extract values from csv
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		// Tokenize each line with delimiter
		lineTokenizer.setDelimiter(",");
		
		// Don't follow strict rule, some columns may not have data
		lineTokenizer.setStrict(false);

		// Setting header information
		lineTokenizer.setNames("id", "order_date", "ship_mode","customer_id","sales"
);

		// FieldSetMapper maps CSV to Customer Object
		BeanWrapperFieldSetMapper<Orders> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Orders.class);

		// Update fieldSetMapper & lineTokenizer in lineMapper
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}
	
	@Bean
	OrdersProcessor processor() {
		return new OrdersProcessor();
	}
	
	// Item Writer - writes data to DB
		RepositoryItemWriter<Orders> writer() {
			RepositoryItemWriter<Orders> itemWriter = new RepositoryItemWriter<>();

			// set repository to be used to write data in db
			itemWriter.setRepository(ordersRepository);

			// set method to be used to save the data in db
			itemWriter.setMethodName("save");

			return itemWriter;
		}
		
		@Bean
		Step step1() {
			return new StepBuilder("step1", jobRepository)
					.<Orders, Orders>chunk(10, transactionManager)
					.reader(reader())
					.processor(processor())
					.writer(writer()) // Your ItemWriter implementation
					.faultTolerant()
					.skip(FlatFileParseException.class)
					.skipLimit(50)
					.build();
		}
		
		
		@Bean
		Job job() {
			//JobBuilder(String name, JobRepository jobRepository)
			return new JobBuilder("ordersJob", jobRepository)
					.incrementer(new RunIdIncrementer())
					.start(step1())
					.build();
		}
	

}
