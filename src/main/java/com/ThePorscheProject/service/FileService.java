package com.ThePorscheProject.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ThePorscheProject.domain.Master;
import com.ThePorscheProject.domain.ModelDescription;
import com.ThePorscheProject.domain.SeriesBanner;
import com.ThePorscheProject.repository.MasterRepository;
import com.ThePorscheProject.repository.ModelDescriptionRepository;
import com.ThePorscheProject.repository.SeriesBannerRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Service
public class FileService {

	private SeriesBannerRepository seriesBannerRepo;
	private ModelDescriptionRepository modelDescriptionRepo;
	private MasterRepository masterRepo;

	public FileService(SeriesBannerRepository seriesBannerRepo, ModelDescriptionRepository modelDescriptionRepo,
			MasterRepository masterRepo) {
		super();
		this.seriesBannerRepo = seriesBannerRepo;
		this.modelDescriptionRepo = modelDescriptionRepo;
		this.masterRepo = masterRepo;
	}

	
	private List<String[]> readCsvFile(String fileName) {
		try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
			List<String[]> records = csvReader.readAll();
			if (!records.isEmpty()) {
				System.out.println("Skipping header: " + String.join(", ", records.get(0)));
				records.remove(0);
			}
			return records;
		} catch (IOException | CsvException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public void readBannerFile() {
		List<String[]> records = readCsvFile("SeriesBanner.csv");
		List<SeriesBanner> banners = records.stream().map(record -> {
			SeriesBanner seriesBanner = new SeriesBanner();
			seriesBanner.setId(Integer.parseInt(record[0]));
			seriesBanner.setSeriesName(record[1]);
			seriesBanner.setPhoto(record[2]);
			return seriesBanner;
		}).collect(Collectors.toList());
		seriesBannerRepo.saveAll(banners);
	}

	public void readDescriptionFile() {
		List<String[]> records = readCsvFile("ModelDescriptions.csv");
		List<ModelDescription> descriptions = records.stream().map(record -> {
			ModelDescription modelDescription = new ModelDescription();
			modelDescription.setId(Integer.parseInt(record[0]));
			modelDescription.setSeriesName(record[1]);
			modelDescription.setSeriesCategory(record[2]);
			modelDescription.setDescription(record[3]);
			modelDescription.setPhoto(record[4]);
			return modelDescription;
		}).collect(Collectors.toList());
		modelDescriptionRepo.saveAll(descriptions);
	}

	public void readMasterFile() {
		List<String[]> records = readCsvFile("Master.csv");
		List<Master> masters = records.stream().map(record -> {
			Master master = new Master();
			master.setId(Integer.parseInt(record[0]));
			master.setSeriesName(record[1]);
			master.setSeriesCategory(record[2]);
			master.setModel(record[3]);
			master.setStartYear(Integer.parseInt(record[4]));
			master.setEndYear(Integer.parseInt(record[5]));
			master.setDescription(record[6]);
			master.setPhoto(record[7]);
			master.setLabels(record[8]);
			return master;
		}).collect(Collectors.toList());
		masterRepo.saveAll(masters);
	}
}
