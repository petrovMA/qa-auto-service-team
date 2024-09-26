package ru.action_tech.qa.auto.api_models.accesses.license.v1.get_child_data

data class GetChildDataResponse(
    val learningAssessment: String?,
    val learningDates: LearningDates?,
    val learningProgram: String?,
    val uploadedDocuments: List<UploadedDocument?>?
) {
    data class LearningDates(
        val endDate: String?,
        val startDate: String?
    )

    data class UploadedDocument(
        val name: String?,
        val status: String?
    )
}