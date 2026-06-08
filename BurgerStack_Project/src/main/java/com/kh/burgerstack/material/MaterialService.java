package com.kh.burgerstack.material;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaterialService {

    @Autowired
    private MaterialDao materialDao;

    @Transactional
    public int materialInsert(Material m) {
        return materialDao.materialInsert(m);
    } //materialInsert
    
    public ArrayList<Material> selectMaterialList() {
    	return materialDao.selectMaterialList();
    } //selectMaterialList
    
    public Material materialDetail(Integer materialId) {
    	return materialDao.materialDetail(materialId);
    } //materialDetail
    
    @Transactional
    public int updateMaterial(Material m) {
    	return materialDao.updateMaterial(m);
    }
    
    public Material selectMaterial(Integer finalMaterialId) {
		return materialDao.selectMaterial(finalMaterialId);
	}
    
    @Transactional
    public int deleteMaterial(Integer materialId) {
    	return materialDao.deleteMaterial(materialId);
    }
}
