package org.medzee.model.input;

import lombok.Data;
import org.medzee.entity.RoutineEntity;

@Data
public class UserRoutineInputModel {
    RoutineEntity.RoutineTimings timings;
}
