package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.access_backend.AccessBackendRequests.accessCreate
import ru.action_tech.qa.auto.api_models.access_backend.AccessBackendRequests.accessUserGetActive
import ru.action_tech.qa.auto.api_models.access_backend.AccessBackendRequests.qaAccessCreate
import ru.action_tech.qa.auto.api_models.access_backend.AccessType
import ru.action_tech.qa.auto.api_models.access_backend.access.v2.user_get_active.response.UserGetActiveResponse
import ru.action_tech.qa.auto.api_models.access_backend.v1.qa.AccessCreateResponse
import ru.action_tech.qa.auto.api_models.access_backend.v1.qa.models.CreateAccessQARequest
import ru.action_tech.qa.auto.core.commons.api.access_backend.qaApiAccessBackend
import ru.action_tech.qa.auto.data.ProductData
import ru.action_tech.qa.auto.data.ProductDataBlocks
import ru.action_tech.qa.auto.data.ProductDataSubscription
import ru.action_tech.qa.auto.utils.accessBackendStoragesClient
import java.time.LocalDateTime


object UserHelper {

    fun createUserWithAccess(userId: Int): AccessCreateResponse = qaApiAccessBackend.send(
        qaAccessCreate(
            CreateAccessQARequest(
                userId = userId,
                productVersion = ProductData.PRODUCT_VERSION,
                simpleProduct = ProductData.SIMPLE_PRODUCT,
                dateEnd = LocalDateTime.now().plusDays(7).toString()
            )
        )
    )

    fun createUserWithAccessSubscription(userId: Int, userCount: Int = 2): AccessCreateResponse {
        return qaApiAccessBackend.send(
            accessCreate(
                CreateAccessQARequest(
                    userId = userId,
                    productVersion = ProductDataSubscription.PRODUCT_VERSION_SUBSCRIPTION,
                    simpleProduct = ProductDataSubscription.SIMPLE_PRODUCT_SUBSCRIPTION,
                    dateEnd = LocalDateTime.now().plusDays(7).toString(),
                    paidAccessStatusId = 6,
                    accessType = AccessType.PAID_ACCESS,
                    attributes = CreateAccessQARequest.Attributes(
                        structureType = ProductDataSubscription.STRUCTURE_TYPE_SUBSCRIPTION,
                        userCount = userCount
                    )
                )
            )
        )
    }

    fun createAccessBlocks(
        access: AccessCreateResponse,
        userCount: Int = 2,
        productVersion: Int = ProductDataBlocks.PRODUCT_VERSION_BLOCKS,
        simpleProduct: String = ProductDataBlocks.SIMPLE_PRODUCT_BLOCKS
    ): AccessCreateResponse = qaApiAccessBackend.send(
        accessCreate(
            CreateAccessQARequest(
                productVersion = productVersion,
                simpleProduct = simpleProduct,
                dateEnd = LocalDateTime.now().plusDays(7).toString(),
                accessType = AccessType.PAID_ACCESS,
                paidAccessStatusId = 6,
                attributes = CreateAccessQARequest.Attributes(
                    parentId = access.access.commonId,
                    structureType = ProductDataBlocks.STRUCTURE_TYPE_BLOCKS,
                    userCount = userCount
                )
            )
        )
    )

    fun getActiveUserAccess(bitrixId: Int): UserGetActiveResponse =
        accessBackendStoragesClient.send(accessUserGetActive(bitrixId))
}