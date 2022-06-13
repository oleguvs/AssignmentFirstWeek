package com.example.okuzminykh.assignmentfirstweek.arch.mapper

interface Mapper<in Model, out DomainModel> {

    fun toDomain(model: Model): DomainModel
}