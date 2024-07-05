package com.company.community.internal.repository.jpa.impl

import com.company.community.internal.entity.jpa.UsersEntity
import com.company.community.internal.repository.jpa.UsersCustomRepository
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.stereotype.Repository


@Repository
class UsersEntityRepositoryImpl(
    private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor,
) : UsersCustomRepository {


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