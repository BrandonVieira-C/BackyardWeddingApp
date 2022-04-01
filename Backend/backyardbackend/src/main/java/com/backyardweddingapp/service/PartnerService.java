package com.backyardweddingapp.service;

import java.util.List;

import com.backyardweddingapp.dto.BackyardDTO;
import com.backyardweddingapp.dto.PartnerDTO;
import com.backyardweddingapp.exception.BackyardWeddingException;

public interface PartnerService {
  Integer addPartner(PartnerDTO partnerDTO) throws BackyardWeddingException; //returns newly added partnerId
  PartnerDTO getPartner(Integer partnerId) throws BackyardWeddingException;
  String deletePartner(Integer partnerId) throws BackyardWeddingException;

  List<PartnerDTO> getAllPartner() throws BackyardWeddingException;

  Integer addBackyardForPartner(Integer partnerId, BackyardDTO backyardDTO) throws BackyardWeddingException; //returns newly added backyardId.
  String deleteBackyard(Integer backyardId) throws BackyardWeddingException; //returns success message
}
