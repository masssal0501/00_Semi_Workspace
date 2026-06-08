package com.kh.burgerstack.material;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaterialMapper {

	public int insert(Material m);
	
	public ArrayList<Material> selectMaterialList();
	public Material materialDetail(Integer materialId);
	public int updateMaterial(Material m);
	public Material selectMaterial(Integer finalMaterialId);
	public int deleteMaterial(Integer materialId);
}
