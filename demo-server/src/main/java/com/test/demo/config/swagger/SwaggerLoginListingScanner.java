package com.test.demo.config.swagger;

import com.fasterxml.classmate.TypeResolver;
import com.test.demo.dto.user.UserDTO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

import java.util.*;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
public class SwaggerLoginListingScanner implements ApiListingScannerPlugin {

    private final CachingOperationNameGenerator operationNames;


    public SwaggerLoginListingScanner(CachingOperationNameGenerator operationNames) {
        this.operationNames = operationNames;
    }

    @Override
    public List<ApiDescription> apply(DocumentationContext context) {
        return new ArrayList<>(
                Collections.singletonList(
                        new ApiDescription(null, "/login", "login", Collections.singletonList(
                                new OperationBuilder(operationNames)
                                        .summary("login")
                                        .tags(Collections.singleton("Authentication"))
                                        .authorizations(new ArrayList<>())
                                        .codegenMethodNameStem("loginPost")
                                        .method(HttpMethod.POST)
                                        .notes("This is a login method")
                                        .parameters(
                                                Collections.singletonList(
                                                        new ParameterBuilder()
                                                                .description("Login Parameter")
                                                                .type(new TypeResolver().resolve(UserDTO.class))
                                                                .name("userLogin")
                                                                .parameterType("body")
                                                                .parameterAccess("access")
                                                                .required(true)
                                                                .modelRef(new ModelRef("UserDTO"))
                                                                .build()
                                                )
                                        )
                                        .responseModel(new ModelRef(("UserToken")))
                                        .responseMessages(responseMessages())
                                        .build()
                        ), false)));
    }


    private Set<ResponseMessage> responseMessages() { //<8>
        return new HashSet<>(Arrays.asList(
                new ResponseMessageBuilder()
                        .code(200)
                        .responseModel(new ModelRef("Void"))
                        .build(),
                new ResponseMessageBuilder()
                        .code(401)
                        .responseModel(new ModelRef("Void"))
                        .build(),
                new ResponseMessageBuilder()
                        .code(403)
                        .responseModel(new ModelRef("Void"))
                        .build(),
                new ResponseMessageBuilder()
                        .code(404)
                        .responseModel(new ModelRef("Void"))
                        .build()
        ));
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return DocumentationType.SWAGGER_2.equals(delimiter);
    }
}
