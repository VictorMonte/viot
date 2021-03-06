package viot.batch.avro;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class AvroConsumer {

    private Consumer<String, GenericRecord> consumer; //1
    public AvroConsumer(String brokers, String schemaRegistryUrl) { //2
        Properties props = new Properties();
        props.put("group.id", "healthcheck-processor");
        props.put("bootstrap.servers", brokers);
        props.put("key.deserializer", StringDeserializer.class); //3
        props.put("value.deserializer", KafkaAvroDeserializer.class); //4
        props.put("schema.registry.url", schemaRegistryUrl); //5
        consumer = new KafkaConsumer<>(props); //6
    }


}
