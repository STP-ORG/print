package io.mosip.print.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.mosip.print.model.CertificateEntry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;

/**
 * Response class for Signature
 * 
 * @author Urvil Joshi
 * @since 1.0.0
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class representing a Signature Response")
public class SignatureCertificate {

	/**
	 * The string alias
	 */
	@JsonIgnore
	private String alias;

	/**
	 * Field for public key
	 */
	@ApiModelProperty(notes = "Public key in BASE64 encoding format", required = true)
	private CertificateEntry<X509Certificate, PrivateKey> certificateEntry;

	/**
	 * Key creation time
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@ApiModelProperty(notes = "Timestamp of issuance of public key", required = true)
	private LocalDateTime issuedAt;

	/**
	 * Key expiry time
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@ApiModelProperty(notes = "Timestamp of expiry of public key", required = true)
	private LocalDateTime expiryAt;

	/**
	 * The string keystore provider name
	 */
	private String providerName;
	

	@Override
	public String toString() {
		return "SignatureCertificate [alias=" + alias + ", certificateEntry=" + certificateEntry + ", issuedAt="
				+ issuedAt + ", expiryAt=" + expiryAt + "]";
	}
	  
}
