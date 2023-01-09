package SpoonacularAPI;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "result",
        "offset",
        "number",
        "totalResults"
})
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Response {

    @JsonProperty("results")
    private List<Result> results;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty
    private int totalResults;

    @JsonProperty("cuisine")
    private String cuisine;
    @JsonProperty("cuisines")
    private List<String> cuisines;
    @JsonProperty("confidence")
    private Double confidence;

    @JsonProperty("vegetarian")
    private Boolean vegetarian;
    @JsonProperty("vegan")
    private Boolean vegan;
    @JsonProperty("glutenFree")
    private Boolean glutenFree;
    @JsonProperty("dairyFree")
    private Boolean dairyFree;
    @JsonProperty("id")
    private int id;
    @JsonProperty("readyInMinutes")
    private int readyInMinutes;
    @JsonProperty("title")
    private String title;
    @JsonProperty("diets")
    private List<String> diets;



    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "title",
            "image",
            "imageType"
    })
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class Result{
        @JsonProperty("id")
        private int id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("image")
        private String image;
        @JsonProperty
        private String imageType;

        @JsonProperty("vegetarian")
        private Boolean vegetarian;


        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<>();
    }
}

