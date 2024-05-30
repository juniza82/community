package com.company.community.internal.repository.jpa.impl

import com.company.community.intenal.entity.jpa.UsersEntity
import com.company.community.internal.repository.jpa.CustomAdminRepository
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.stereotype.Repository


@Repository
class UsersEntityRepositoryImpl(
    private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor,
) : CustomAdminRepository {


    override fun findByUserName(filter: String): List<UsersEntity> {
        return kotlinJdslJpqlExecutor
            .findAll {
                select(entity(UsersEntity::class))
                    .from(entity(UsersEntity::class))
                    .whereAnd(
                        path(UsersEntity::userName).like("%${filter}%"),
                    )
            }
            .filterNotNull()
    }

}