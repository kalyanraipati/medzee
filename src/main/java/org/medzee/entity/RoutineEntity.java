package org.medzee.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "routine_info")
public class RoutineEntity extends BaseEntity {
    String registrationId;
    RoutineTimings timings;

    @Data
    public static class RoutineTimings {
        String breakFastTime;
        String lunchTime;
        String dinnerTime;
        String wakeUpTime;
        String bedTime;
        String snackTime;
    }
}
