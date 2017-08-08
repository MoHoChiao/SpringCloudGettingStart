package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

/**
 * 這個類別為Ribbon的配置類別
 * 注意：此配置類別不可以出現在主程式上下文的@ComponentScan 中
 * 由於@SpringBootApplication包括了@ComponentScan
 * 所以如果此類別放在@SpringBootApplication所作用的package,則其下所有的ribbon client都會共享這個配置
 */
@Configuration
public class RibbonConfiguration {
  @Bean
  public IRule ribbonRule() {
	//若不特別撰寫這個配置類別,則預設ribbon的load balanced rule為輪流
	return new RoundRobinRule();	//如果要Round Robin,不用特別寫,預設robbin的行為就是它,這裡只是為了展示有多樣選擇
	  
    // load balanced rule，random choose
    //return new RandomRule();
	  
	// load balanced rule，This rule will skip servers that are deemed "circuit tripped" or with high concurrent connection count.
    //return new AvailabilityFilteringRule();
    
    /*
     *  load balanced rule
     *  For this rule, each server is given a weight according to its average response time. The longer the 
     *  response time, the less weight it will get. The rule randomly picks a server where the possibility is 
     *  determined by server's weight.
     */
    //return new WeightedResponseTimeRule();
  }
}