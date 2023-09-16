package org.example.utils;

import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.PrintWriter;

@UtilityClass
public class ResponseErrorMessageUtil {
    public static void setResponseError(HttpServletResponse response, int errorCode, String errorMessage) throws IOException {
        try (PrintWriter writer = response.getWriter()) {
            response.setStatus(errorCode);
            response.setCharacterEncoding("UTF-8");
            writer.write(errorMessage);
        }
    }

    public static void setResponseError(HttpServletResponse response, int errorCode,
                                        String errorMessage, String contentType) throws IOException
    {
        try (PrintWriter writer = response.getWriter()) {
            response.setStatus(errorCode);
            response.setCharacterEncoding("UTF-8");
            response.setContentType(contentType);
            writer.write(errorMessage);
        }
    }
}
