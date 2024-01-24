package com.vasquez.msclient.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "document_type")
public class DocumentType {

    @Id
    private String  documentTypeId;

    @NotNull
    private String name;

}
