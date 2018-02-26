package com.sidarau.socialko.di.auth

import com.sidarau.socialko.di.ActivityScope
import com.sidarau.socialko.domain.core.validation.DefaultValidator
import com.sidarau.socialko.domain.core.validation.RulesContainer
import com.sidarau.socialko.domain.core.validation.UserRuleContainer
import com.sidarau.socialko.domain.core.validation.Validator
import com.sidarau.socialko.repositories.auth.DefaultUserRepository
import com.sidarau.socialko.repositories.auth.UserRepository
import dagger.Binds
import dagger.Module

/**
 * @author Anton Sidorov
 */
@Module(includes = arrayOf(AuthFragmentBuilderModule::class))
interface AuthModule {

    @ActivityScope
    @Binds
    fun provideUserRepository(repository: DefaultUserRepository): UserRepository

    @ActivityScope
    @Binds
    fun provideValidator(validator: DefaultValidator): Validator

    @ActivityScope
    @Binds
    fun provideRuleContainer(container: UserRuleContainer): RulesContainer
}