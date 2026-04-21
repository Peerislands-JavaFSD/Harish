import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TaxCalculator taxCalculator() {
        return new calculator();
    }

    @Bean
    public PerformanceBonus performanceBonus() {
        return new BasicBonus();
    }

    @Bean
    public PayrollProcessor payrollProcessor() {
        PayrollProcessor processor = new PayrollProcessor(taxCalculator(),"TechCorp Solution",2026);
        processor.setBonusScheme(performanceBonus());
        return processor;
    }
}