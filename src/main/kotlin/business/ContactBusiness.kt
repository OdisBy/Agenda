package business

import Entity.ContactEntity
import repository.ContactRepository

class ContactBusiness {
    private fun validate(name: String, phone: String)
    {
        if(name == "")
        {
            throw Exception("Nome é obrigatório")
        }

        if(phone == "")
        {
            throw Exception("Telefone é obrigatório")
        }
    }

    private fun validateDelete(name: String, phone: String)
    {
        if(name == "" || phone == "")
        {
            throw Exception("É necessário selecionar um contato para remover.")
        }
    }

    fun save(name: String, phone: String)
    {
        validate(name, phone);
        val contact = ContactEntity(name, phone);
        ContactRepository.save(contact);
    }

    fun delete(name: String, phone: String){
        validateDelete(name, phone);
        val contact = ContactEntity(name, phone);
        ContactRepository.delete(contact);
    }

    fun getList() : List<ContactEntity>
    {
        return ContactRepository.getList()
    }

    fun getContactCountDescription() : String {
        val list = getList();
        return if(list.isEmpty()) {
            "0 Contatos"
        }else{
            "${list.size} contatos"
        }
    }
}