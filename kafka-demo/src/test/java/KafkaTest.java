import com.chenjw.KafkaDemoApplication;
import com.chenjw.consumer.ConsumerDemo;
import com.chenjw.producer.ProducerDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaDemoApplication.class)
public class KafkaTest {


    @Resource
    private ProducerDemo producerDemo;

    @Resource
    private ConsumerDemo consumerDemo;

    @Test
    public void kafkaSendTest() {
        producerDemo.kafkaSendTest();
    }

//    @Test
//    public void kafkaConsumeTest() {
//        consumerDemo.receive("2222222");
//    }

}
