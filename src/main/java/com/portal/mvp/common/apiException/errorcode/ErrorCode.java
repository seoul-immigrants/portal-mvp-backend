package com.portal.mvp.common.apiException.errorcode;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    /**
     * E000 공통 오류
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E000", "승인되지 않은 요청입니다."), // 401
    FORBIDDEN(HttpStatus.FORBIDDEN, "E001", "접근권한이 없습니다."), // 403
    NOT_FOUND(HttpStatus.NOT_FOUND, "E002", "요청하신 리소스가 존재하지 않습니다."), // 404
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "E003", "지원하지 않는 HTTP 메서드입니다."), // 405
    CONFLICT(HttpStatus.CONFLICT, "E004", "이미 존재하는 데이터 입니다."), // 409
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E10000","정의되지 않은 오류입니다. 관리자에게 문의하세요."), // 500 서버 에러(절대 발생해선 안됨)

    /**
     * E100 잘못된 파라미터 및 바인딩 오류 (status: 400)
     */
    BIND_ERROR(HttpStatus.BAD_REQUEST, "E100", "유효하지 않은 파라미터 입니다."),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "E101", "유효하지 않은 파라미터 입니다."),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "E102", "유효하지 않은 파라미터 입니다."), // 파라미터 형변환 불가
    INVALID_JSON_INPUT(HttpStatus.BAD_REQUEST, "E103", "유효하지 않은 JSON 포맷입니다."), // JSON 형식이 알맞지 않음
    BIND_ERROR_ENUM_CODE(HttpStatus.BAD_REQUEST, "E104", "유효하지 않은 파라미터 입니다."), // ENUM에 정의되지 않은 코드
    DATA_INTEGRITY_VIOLATION_ERROR(HttpStatus.BAD_REQUEST, "E105", "유효하지 않은 파라미터 입니다."), // 데이터무결성 제약조건 위배

    /**
     *  도메인 기준으로 기타 에러 코드 정의(샘플 에러 코드: SE)
     */
    NOT_FOUND_SAMPLE(HttpStatus.NOT_FOUND, "SE001", "해당 샘플을 찾을 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String errorCode;
    private final String message;

    ErrorCode(HttpStatus status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }
}
