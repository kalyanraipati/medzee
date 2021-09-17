package org.medzee.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "partner_info")
public class PartnerInfoEntity extends BaseEntity implements Serializable {
    List<Object> partnerList;
}
