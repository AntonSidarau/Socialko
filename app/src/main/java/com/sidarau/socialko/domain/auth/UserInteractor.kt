package com.sidarau.socialko.domain.auth

import com.sidarau.socialko.data.network.auth.AuthEncoder
import com.sidarau.socialko.di.ActivityScope
import com.sidarau.socialko.domain.core.validation.UserRuleContainer
import com.sidarau.socialko.domain.core.validation.Validator
import com.sidarau.socialko.models.domain.user.AuthUser
import com.sidarau.socialko.models.domain.user.User
import com.sidarau.socialko.repositories.auth.UserRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@ActivityScope
class UserInteractor @Inject constructor(
        private val validator: Validator,
        private val authEncoder: AuthEncoder,
        private val userRepository: UserRepository
) {

    fun login(user: AuthUser): Maybe<User> {
        return userRepository.login(authEncoder.getEncodedData(user))
    }

    fun validateLogin(user: AuthUser): Single<List<String>> {
        setupLoginValidators(user)
        return Observable.fromIterable(validator.getResults())
                .filter { !it.first }
                .map { it.second }
                .toList()
    }

    fun validateRegister(user: AuthUser): Single<List<String>> =
            Single.just(user)
                    .map { setupRegisterValidators(user) }
                    .flatMap {
                        Observable.fromIterable(validator.getResults())
                                .filter { !it.first }
                                .map { it.second }
                                .toList()
                    }


    fun signUp(user: AuthUser): Completable = userRepository.signUp(user)

    private fun setupLoginValidators(user: AuthUser) {
        validator.addField(UserRuleContainer.EMAIL, user.email)
        validator.addField(UserRuleContainer.PASSWORD, user.password)
    }

    private fun setupRegisterValidators(user: AuthUser) {
        validator.addField(UserRuleContainer.FIRST_NAME, user.firstName)
        validator.addField(UserRuleContainer.LAST_NAME, user.lastName)
        validator.addField(UserRuleContainer.EMAIL, user.email)
        validator.addField(UserRuleContainer.PASSWORD, user.password)
    }
}