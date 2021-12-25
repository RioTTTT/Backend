
package Backend;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "success",
    "data"
})

@Setter
@Getter
public class IgmurApi implements Serializable
{

    @JsonProperty("status")
    public Integer status;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("data")
    public Data data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -388574436434239238L;

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
