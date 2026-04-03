package day.budi.catalog.dto;

public record ApiResponse<T>(T data) {

    public static <T> ApiResponse<T> of(T data) {
        return new ApiResponse<>(data);
    }

    public static ApiResponse<String> ok() {
        return new ApiResponse<>("Ok");
    }
}
