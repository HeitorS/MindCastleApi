package com.api.rest.mapper

import org.springframework.stereotype.Component
import com.api.rest.dto.EndPesForm
import com.api.rest.model.EndPesEmb
import com.api.rest.model.EndPes

@Component
class EndPesFormMapper: Mapper<EndPesForm, EndPes> {
    override fun map(e: EndPesForm): EndPes {
        return EndPes(
            fk = EndPesEmb(
                id_pessoa = e.id_pessoa,
                id_endereco = e.id_endereco
            )
        )
    }
}