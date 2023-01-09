package SpoonacularAPI;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "slot",
        "position",
        "type",
        "value"
})

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddMealRequest {
    @JsonProperty("status")
    private String status;
    @JsonProperty("mealPlan")
    private MealPlan mealPlan;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MealPlan {
        @JsonProperty("id")
        private int id;
        @JsonProperty("days")
        private List<Day> days;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Day{

        }
    }

}
