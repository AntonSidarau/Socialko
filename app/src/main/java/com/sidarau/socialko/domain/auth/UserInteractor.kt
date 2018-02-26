package com.sidarau.socialko.domain.auth

import com.sidarau.socialko.di.ActivityScope
import com.sidarau.socialko.domain.core.validation.UserRuleContainer
import com.sidarau.socialko.domain.core.validation.Validator
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
        private val userRepository: UserRepository
) {

    fun login(): Maybe<User> {
        throw UnsupportedOperationException()
    }

    fun validateRegister(user: User): Single<List<String>> =
            Single.just(user)
                    .map { setupRegisterValidators(user) }
                    .flatMap {
                        Observable.fromIterable(validator.getResults())
                                .filter { !it.first }
                                .map { it.second }
                                .toList()
                    }


    fun signUp(user: User): Completable = userRepository.signUp(user)

    private fun setupRegisterValidators(user: User) {
        validator.addField(UserRuleContainer.FIRST_NAME, user.firstName)
        validator.addField(UserRuleContainer.LAST_NAME, user.lastName)
        validator.addField(UserRuleContainer.EMAIL, user.email)
        validator.addField(UserRuleContainer.PASSWORD, user.password)
    }
}