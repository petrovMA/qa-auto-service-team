package ru.action_tech.qa.auto.api_tests.supports.support.v1.analysis_bush_customers_get_by_customer_ids.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.Response_200_Ok
import ru.action_tech.qa.auto.api_models.Sale_Supports
import ru.action_tech.qa.auto.api_models.supports.AnalysisBushCustomersGetByCustomerIdsV1
import ru.action_tech.qa.auto.api_models.supports.SupportsRequests.analysisBushCustomersGetByCustomerIds
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.core.assertions.assertTrue
import ru.action_tech.qa.auto.core.invocation.invoke
import ru.action_tech.qa.auto.utils.supportsCrmClient

class Test_AnalysisBushCustomersGetByCustomerIdsPositive {


    @Sale_Supports
    @AnalysisBushCustomersGetByCustomerIdsV1
    @Response_200_Ok
    @Requirements("REQCRM-967")
    @Test
    @DisplayName("/api/v1/analysis-bush-customers_get-by-customer-ids -> 200 Ok: Вернулся список клиентов")
    @AllureId("177262")
    fun test() {
        val response = supportsCrmClient.send(analysisBushCustomersGetByCustomerIds(customerIds = customerIds))

        "Проверяем, что ответ НЕ пустой" { assertTrue(response.isNotEmpty()) }
    }

    private val customerIds by lazy {
        listOf(
            "c1865ec9-733a-4814-b8d2-656623afdd39",
            "b2236f58-a983-4b38-8422-89bff8bd6dd2",
            "bce88e3f-3477-451c-abc6-1d6ac8fdcf33",
            "757c5ff2-4b88-e511-8e6e-78e3b502da44",
            "aab3ba49-f286-459a-9958-e96e27b12050",
            "fca5b26c-f906-4b68-a192-539f0affa979",
            "9d69db1e-4710-49a8-b42b-ae0c9f56fbea",
            "fbf794b8-2ed7-42fb-beab-68c930f33c69",
            "0cf70c06-8f62-e511-a890-78e3b502da44",
            "323c3a33-2203-4cd0-b156-17565c987093",
            "3503fe1e-ffb6-4833-aad0-76e602a73484",
            "e4fac559-dd96-463c-adf7-7d4d94cb8421",
            "3fa5b27c-f1db-4f1b-a436-55d02a3ef89e",
            "ff4bd012-2a44-461b-a27f-07ee7699d83d",
            "c509d323-913b-469e-a545-90b6da0ac120",
            "79ec7b02-008d-4d70-bb32-532a0a79a2ed",
            "b5003be9-429a-e411-82a0-78e3b502da44",
            "1a121c9f-dab1-4013-ad43-c69bbe707b37",
            "f23ce2b8-0629-48f1-bfa2-d1ae297b369c",
            "0b94e1b0-0333-4768-9ac5-273cce69d0cb",
            "bd62cfe7-5930-4c26-b6a1-66ee7876ca78",
            "32cb9e7a-4223-4ee6-a38a-ba34229cf358",
            "2f36e784-4a1b-452d-8fe8-5d913f142b58",
            "98940508-9635-4156-ac4e-6c55fb4fc60c",
            "b45a7794-c221-4d7d-a3d5-0e77342063ff",
            "3ac2830b-335d-e611-86cf-78e3b502da44",
            "8a36e385-75f0-4440-bdf3-c507283f4902",
            "4cd8c056-3d7d-47f0-bdea-4e673185ea5a",
            "f838fbee-3eb4-45f3-acb0-f90a0ae27587",
            "94ae891e-301b-4261-abb5-cb5a67cb492d",
            "3cea1776-b83f-40f6-9643-65cd84c5e9d5",
            "c40152ed-2731-4eb1-bf07-ddf98d62dae5",
            "c1bff847-6bf5-4536-95bf-ff6214df9b35",
            "108eebb2-bc3a-48e4-aa33-42bef36fe17c",
            "8185e288-8409-496c-b6e4-b83a1dd7cd62",
            "e4caa870-4c47-4794-91ca-876e9d5165cc",
            "16ba27a0-d79b-46c4-b6e9-3f06f576926d",
            "3d2ec526-6e2b-43d9-8362-0feba0b5d90e",
            "839bccf4-117d-4e7a-8ade-1ee37b6e7326",
            "da6621a2-ca16-493e-ad5f-293fc34ac05e",
            "4a2c4581-3845-4ebc-a82f-b6753b677eb2",
            "a6a49191-9dfd-4a80-ba04-4bad34a82a43",
            "6bcd1563-fd82-47aa-8232-42fbaf5acc33",
            "e04b0079-9c42-4244-bfdb-7a8d5d7b1695",
            "6deb1498-31eb-4e7e-8c7e-2b3724d07e4b",
            "f41d3371-a717-e411-a12a-78e3b502da44",
            "c04f15a4-b859-458d-b715-98ca5285a8e2",
            "255df4e7-0a99-4f87-b730-e81dbd4bf888",
            "eacb61b4-d176-4734-9a82-78eb8a92b2c9",
            "9ac2a306-ba3c-4646-b7fa-83e657f2dd2f",
            "67e70236-3977-4b11-a18a-672fdb144fc2",
            "b2b4720e-1d0f-4409-958c-fa0c370f515e",
            "039dcf3a-81f4-4beb-b940-d4c1c1b6e21f",
            "4b4deb43-5fea-4e63-bac7-662f4be9a402",
            "9a6d5707-4237-4454-a387-01fe612479d0",
            "c4328e5c-bc4a-4c5a-b77f-95a783f838a9",
            "b6b34544-5883-4284-83cc-6947b7e82a6d",
            "79fc3413-dddc-47c7-9476-667d7c038d94",
            "3bbf8421-8ddd-450f-b59c-9045cb206e96",
            "bb96cecc-abe2-41aa-bd17-a9400604cc99",
            "5008d889-5a94-49aa-adbe-da905032d96c",
            "658a8aae-f609-4155-a740-312af22f64c7",
            "4b490221-30e0-44a5-9c03-d4c0e945059d",
            "288c3903-0c72-4354-ba2d-353f4d76f5fa",
            "2413f9b1-3ea4-41fa-bd53-788f5911e8d4",
            "b9b82010-ccdd-4061-93a8-14e4616431cc",
            "a1e38581-cb63-4514-bcc6-42f0935f33e5",
            "be3848f1-e1dc-4acb-a0db-82ff81f0164b",
            "dd722767-ccb1-4d81-9e35-ee3ffd4f3c99",
            "cf161f9d-14b2-4a0b-b6e7-3537b7136796",
            "af292c70-5e98-4793-b98f-95ffeabe94df",
            "573416c3-afa5-40b8-990c-aa771b9a061d",
            "c981870c-77c7-4464-84b6-51e863ab82cc",
            "41765111-4dcd-4bd8-8ea7-9c658e7d5236",
            "7434c4ea-3549-4570-bb8f-68c607de54c9",
            "f4ec5f6f-d3a5-4598-9807-c79921643854",
            "c30fc3b1-4609-4bd8-acbf-b425a8cabbd1",
            "68f2835e-bccc-4e63-81b7-f3fd90e51dae",
            "71695aa0-094c-46d3-8e7d-1f49604e127e",
            "af2f8fa6-8061-4c28-bd63-be2f923bcab7",
            "523755d3-fbd5-483f-8e7d-475134a8fa1e",
            "4caccc11-7e73-e711-a20a-00155dfbf212",
            "4faf968f-5e33-4344-8c58-9afdcb2ddf03",
            "e88f2e6a-0b37-4935-9c11-2b99cef414ff",
            "c47e3dda-8db3-4f15-a293-2baed965bf6b",
            "42803b0d-dcd6-4dee-9c4f-5bdcbad972b1",
            "68d25d05-c18d-4e10-8a8d-bdd50b2f3a4d",
            "83265132-e6cd-4c7d-b565-a2ac61e0c858",
            "8917bab0-5647-4ad1-abba-a36c93262229",
            "90277dfc-7909-408f-bf1e-68dd6f666f1e",
            "62000ad1-c2bc-4247-bf2a-75c11617fdb5",
            "c7437a7a-056f-e411-82a0-78e3b502da44",
            "5369dea6-8706-41be-b6b4-ea3a18516ef7",
            "f180610a-e04c-449d-9d0e-55e900f9cf79",
            "f19a3f21-16fa-4a4f-b02a-abe73b8f87cc",
            "b7dafdbc-eff4-4fae-9d0d-3ffae9fb8c4e",
            "b37e44bb-c262-4447-a911-4d3417b20a75",
            "f8c15ad4-15a7-e611-a879-78e3b502da44",
            "020e5d6e-638a-4551-bbc9-ab208efe8915",
            "b7e063b1-829c-4ca3-a149-956c1832cd10"
        )
    }
}