package com.example.ExamenWeb_AlejandroHaro.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asset {
	private byte[] content;
	private String contentType;
}
