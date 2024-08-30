package ru.action_tech.qa.auto.ui_models.admin360

import ru.action_tech.qa.auto.ui_models.admin360.authPage.AuthPage
import ru.action_tech.qa.auto.ui_models.admin360.create_task.Application
import ru.action_tech.qa.auto.ui_models.admin360.taskPage.TasksPage

object A360Pages {
    val authPage by lazy { AuthPage() }
    val taskPage by lazy { TasksPage() }
    val application by lazy { Application() }
}