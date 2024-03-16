package uz.ilmnajot.adminpanel.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

//@OpenAPIDefinition(
//        info = @Info(
//                contact = @Contact(
//                        name = "Library",
//                        url = "https://sampm.uz",
//                        email = "ilmnajot2021@gmail.com"
//                ),
//                title = "Library_system in SamPS - Elbek_Umar",
//                description = "This website is for using in library in only SamPS",
//                version = "1.0",
//                license = @License(
//                        name = "MIT License",
//                        url = "http://www.apache.org/mit/mitLicense"
//                ),
//                termsOfService = "Terms of Service"
//        ),
//        servers = {
//                @Server(
//                        description = "Server description here",
//                        url = "http://localhost:7777"
//                ),
//                @Server(
//                        description = "Server description here",
//                        url = "http://localhost:7777"
//
//                )
//        }
//)
//@SecurityScheme(
//        name = "Bearer",
//        description = "Bearer token description here",
//        scheme = "bearer",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        in = SecuritySchemeIn.HEADER
//)
//@Configuration
public class OpenApiConfig {
}
