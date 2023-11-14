package constants;

public enum AuthorizationTextError{

    ERROR_LOGIN_OR_PASSWORD("Некорректный логин/пароль, попробуйте еще раз");

    private String error;

    AuthorizationTextError(String error) {
        this.error = error;
    }

    public String getErrorText() {
        return error;
    }

}

