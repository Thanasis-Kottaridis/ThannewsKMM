package com.thanasis.kottaridis.thannewskmm.domain.utils.helpers

/**
 * Every Mapper object has to implement DomainMapper interface in order to provide 4 methods
 * - modelToDomain: converts target model to domain model
 * - domainToDto: converts domain model to target model
 * - mapModelLists: this method has a default implementation and is used in order to map list of domain model objects into target model lists
 * - mapDomainLists: this method has a default implementation and is used in order to map list of target model objects into domain model lists
 */
interface DomainMapper<Model, DomainModel> {
    fun modelToDomain(model: Model): DomainModel

    fun domainToModel(domainModel: DomainModel): Model

    fun mapModelLists(domainList: List<DomainModel>): List<Model> =
        domainList.map {
            domainToModel(it)
        }

    fun mapDomainLists(modelList: List<Model>): List<DomainModel> =
        modelList.map {
            modelToDomain(it)
        }
}
