
package m.HueApp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "1",
    "2",
    "3"
})
public class Lamp {

    @JsonProperty("1")
    private Product product;

    @JsonProperty("2")
    private Product product2;

    @JsonProperty("3")
    private Product product3;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("1")
    public Product getProduct() {
        return product;
    }

    @JsonProperty("1")
    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonProperty("2")
    public Product getProduct2() {
        return product2;
    }

    @JsonProperty("2")
    public void setProduct2(Product product) {
        this.product2 = product;
    }

    @JsonProperty("3")
    public Product getProduct3() {
        return product3;
    }

    @JsonProperty("3")
    public void setProduct3(Product product) {
        this.product3 = product;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
