package org.medzee.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document(collection = "visits_info")
public class VisitsInfoEntity extends BaseEntity implements Serializable {
    String registrationId;
    List<Object> visitsInfo;
}
