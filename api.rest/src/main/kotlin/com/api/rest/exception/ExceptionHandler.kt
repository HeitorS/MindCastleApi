package com.api.rest.exception

import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.ResponseStatus
import org.hibernate.exception.ConstraintViolationException
import org.springframework.http.HttpStatus
import com.api.rest.dto.ErrorView

import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(ex: NotFoundException, rq: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = ex.message(),
            path = rq.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInputNotEmpty(ex: MethodArgumentNotValidException, rq: HttpServletRequest): ErrorView {
        val message = HashMap<String,String?>()
        ex.bindingResult.fieldErrors.forEach {
                e -> message.put(e.field, e.defaultMessage)
        }
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = message.toString(),
            path = rq.servletPath
        )
    }

    @ExceptionHandler(NoSuchElementException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInputNotNull(ex: NoSuchElementException, rq: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = ex.message,
            path = rq.servletPath
        )
    }

    @ExceptionHandler(EmptyResultDataAccessException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleSearchNotFound(ex: EmptyResultDataAccessException, rq: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.NO_CONTENT.value(),
            error = HttpStatus.NO_CONTENT.name,
            message = NotFoundException().message(),
            path = rq.servletPath
        )
    }

    @ExceptionHandler(SenhaDiferenteCadstroException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleSenhaDiferenteCadstro(ex: SenhaDiferenteCadstroException, rq: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = ex.message(),
            path = rq.servletPath
        )
    }

    @ExceptionHandler(CpfCadastradoException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleCpfCadastrado(ex: CpfCadastradoException, rq: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = ex.message(),
            path = rq.servletPath
        )
    }

    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleCpfCadastrado(ex: ConstraintViolationException, rq: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = ex.message,
            path = rq.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(ex: Exception, rq: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = ex.message,
            path = rq.servletPath
        )
    }

    @ExceptionHandler(EmailCadastradoException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleEmailCadastrado(ex: EmailCadastradoException, rq: HttpServletRequest): ErrorView {
        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = ex.message(),
            path = rq.servletPath
        )
    }
}