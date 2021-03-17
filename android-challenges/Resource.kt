data class Resource<T> (val state: String, val data: T? = null, val message: String? = null, var code: Int? = null) {

    companion object {
        const val NOT_FOUND = "not found"
        const val ERROR = "error"
        const val SUCCESS = "success"
        const val LOADING = "loading"
        const val INVALID = "invalid"
        const val VALID = "valid"
        const val REQUIRES_AUTHENTICATION = "requires authentication"
        const val EMPTY = "empty"
        const val NO_PROFILE_CARD_EXISTS = "NO_PROFILE_CARD_EXISTS"

        fun <T> empty(): Resource<T> {
            return Resource(EMPTY)
        }

        fun <T> custom(state: String, data: T? = null): Resource<T> {
            return Resource(state)
        }

        fun <T> noProfileCardExists(): Resource<T> {
            return Resource(NO_PROFILE_CARD_EXISTS)
        }

        fun <T> requiresAuthentication(): Resource<T> {
            return Resource(REQUIRES_AUTHENTICATION)
        }

        fun <T> valid(data: T? = null): Resource<T> {
            return Resource(VALID, data, null)
        }

        fun <T> invalid(data: T? = null): Resource<T> {
            return Resource(INVALID, data, null)
        }

        fun <T> success(data: T? = null): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> notFound(): Resource<T> {
            return Resource(NOT_FOUND)
        }

        fun <T> error(msg: String? = null, data: T? = null, code: Int? = null): Resource<T> {
            return Resource(ERROR, data, msg, code)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(LOADING, data, null)
        }
    }
}