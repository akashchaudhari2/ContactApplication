package in.com.ezone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan(basePackages = { "in.com.ezone" })
@EnableWebMvc
public class SpringWebConfig extends  WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Bean
	public ViewResolver ViewResolver() {

		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);

		view.setPrefix("/WEB-INF/view/");
		view.setSuffix(".jsp");

		return view;

	}
}
