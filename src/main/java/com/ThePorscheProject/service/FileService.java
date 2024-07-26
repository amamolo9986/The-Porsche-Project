package com.ThePorscheProject.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

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



	public void readBannerFile() {
		try (CSVReader csvReader = new CSVReader(new FileReader("SeriesBanner.csv"))) {
			List<String[]> records = csvReader.readAll();

			if (!records.isEmpty()) {
				System.out.println("Skipping header: " + String.join(", ", records.get(0)));
				records.remove(0);
			}

			for (String[] record : records) {
				Integer id = Integer.parseInt(record[0]);
				String seriesName = record[1];
				String photo = record[2];
				SeriesBanner seriesBanner = new SeriesBanner();
				seriesBanner.setId(id);
				seriesBanner.setSeriesName(seriesName);
				seriesBanner.setPhoto(photo);
				seriesBannerRepo.save(seriesBanner);
			
			}

		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}
	
	public void readDescriptionFile() {
		try (CSVReader csvReader = new CSVReader(new FileReader("ModelDescriptions.csv"))) {
			List<String[]> records = csvReader.readAll();

			if (!records.isEmpty()) {
				System.out.println("Skipping header: " + String.join(", ", records.get(0)));
				records.remove(0);
			}

			for (String[] record : records) {
				Integer id = Integer.parseInt(record[0]);
				String seriesName = record[1];
				String seriesCategory = record[2];	
				String seriesDescription = record[3];
				String photo = record[4];
				ModelDescription modelDescription = new ModelDescription();
				modelDescription.setId(id);
				modelDescription.setSeriesName(seriesName);
				modelDescription.setSeriesCategory(seriesCategory);
				modelDescription.setDescription(seriesDescription);
				modelDescription.setPhoto(photo);
				modelDescriptionRepo.save(modelDescription);
			
			}

		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}
	
	public void readMasterFile() {
		try (CSVReader csvReader = new CSVReader(new FileReader("SeriesBanner.csv"))) {
			List<String[]> records = csvReader.readAll();

			if (!records.isEmpty()) {
				System.out.println("Skipping header: " + String.join(", ", records.get(0)));
				records.remove(0);
			}

			for (String[] record : records) {
				Integer id = Integer.parseInt(record[0]);
				String seriesName = record[1];
				String photo = record[2];
				SeriesBanner seriesBanner = new SeriesBanner();
				seriesBanner.setId(id);
				seriesBanner.setSeriesName(seriesName);
				seriesBanner.setPhoto(photo);
				seriesBannerRepo.save(seriesBanner);
			
			}

		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}

}
