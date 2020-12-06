package practiceOL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class parcticeOlApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext ctx = SpringApplication.run(parcticeOlApplication.class, args);
//		 CouponDailyDeleteByEndDateJob couponDailyDeleteByEndDateJob = ctx.getBean( CouponDailyDeleteByEndDateJob.class);
//		 couponDailyDeleteByEndDateJob.start();
	}

}
