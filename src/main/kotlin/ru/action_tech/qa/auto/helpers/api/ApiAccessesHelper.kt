package ru.action_tech.qa.auto.helpers.api

import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests.licenseGetByTaskId
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests.storageAccessDeactivate
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_by_task_id.LicenseGetByTaskIdRequest
import ru.action_tech.qa.auto.api_models.accesses.license.v1.license_get_by_task_id.LicenseGetByTaskIdResponse
import ru.action_tech.qa.auto.api_models.accesses.storage.v1.storage_access_deactivate.StorageAccessDeactivateRequest
import ru.action_tech.qa.auto.core.utils.waiting.Wait
import ru.action_tech.qa.auto.utils.accessesCrmClient
import ru.action_tech.qa.auto.utils.auth.tokenAutoActionushka

object ApiAccessesHelper {

    fun getLicenseByTask(taskId: String): LicenseGetByTaskIdResponse = Wait.untilNotNull(
        timeoutInMs = 120_000,
        pollingIntervalInMs = 2_000,
        suppressException = true
    ) { accessesCrmClient.send(licenseGetByTaskId(LicenseGetByTaskIdRequest(taskId))) }

    fun deactivateLicense(taskId: String, token: String? = tokenAutoActionushka) {
        val accessId = getLicenseByTask(taskId).id

        accessesCrmClient.send(storageAccessDeactivate(StorageAccessDeactivateRequest(accessId), token))

        Wait.untilTrue(
            timeoutInMs = 60_000,
            pollingIntervalInMs = 2_000,
            suppressException = true
        ) {
            getLicenseByTask(taskId).status == 2
        }
    }
}