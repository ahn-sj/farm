package org.tally.farm.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationResponse<T> {

    private ResultCode result;
    private String errorCode;
    private String message;
    private T data;

    public static ApplicationResponseBuilder created() {
        return success("Successfully created");
    }

    public static ApplicationResponseBuilder updated() {
        return success("Successfully updated");
    }

    public static ApplicationResponseBuilder deleted() {
        return success("Successfully deleted");
    }

    public static ApplicationResponseBuilder success(String message) {
        return ApplicationResponseBuilder.builder()
                .result(ResultCode.SUCCESS)
                .message(message)
                .build();
    }

    public static ApplicationResponseBuilder fail(String errorCode, String message) {
        return ApplicationResponseBuilder.builder()
                .result(ResultCode.FAIL)
                .errorCode(errorCode)
                .message(message)
                .build();
    }

    enum ResultCode {
        SUCCESS,
        FAIL
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApplicationResponseBuilder {

        private ApplicationResponse.ResultCode result;
        private String errorCode;
        private String message;

        public ApplicationResponse<Void> build() {
            return data(null);
        }

        public <T> ApplicationResponse<T> data(T data) {
            return new ApplicationResponse<T>(result, errorCode, message, data);
        }

    }
}





