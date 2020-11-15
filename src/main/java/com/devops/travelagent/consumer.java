package com.devops.travelagent;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class consumer {
	
	
	public static Properties setProperty() {
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"mygroup-second");
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");


		return properties;
		
	}
	
	public static void create() {
		Logger logger = (Logger) LoggerFactory.getLogger(consumer.class.getName());
				
		KafkaConsumer<String,String> consumer1 = new KafkaConsumer<String,String>(setProperty());
		
		consumer1.subscribe(Arrays.asList("firsttopic"));
		
		while(true) {
			ConsumerRecords<String, String> records= consumer1.poll(Duration.ofMillis(100));
			
			for (ConsumerRecord<String, String>  record : records) {
				
				logger.info("Key: "+record.key() + ", Value: "+record.value());
				logger.info("Partition: "+record.partition() + ", Offset: "+record.offset());
				
			}
			consumer1.close();
		}
		
		
		
	}
}
