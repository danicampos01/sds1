import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Filters from '../../components/Filters';
import './styles.css';
import Chart from 'react-apexcharts'
import { barOptions, pieOptions, } from './chart-options';
import { buildBarSeries, getPlatformChartData, getGenderChartData } from './helpers';


type PieChartData = {
    labels: string[];
    series: number[];

}

type BarChartData = {
    x: string;
    y: number;

}

const initialPieData = {
    labels: [],
    series: []
}


const BASE_URL = 'http://localhost:8080'

const Charts = () => {

    const [barChartData, setBarChatDate] = useState<BarChartData[]>([]);
    const [platFormData, setPlatfomrDate] = useState<PieChartData>(initialPieData);
    const [genderData, setGenderDate] = useState<PieChartData>(initialPieData);

    useEffect(() => {
        async function getData() {
            const redordsResponse = await axios.get(`${BASE_URL}/records`);

            const gamesResponse = await axios.get(`${BASE_URL}/games`);

            const barData = buildBarSeries(gamesResponse.data, redordsResponse.data.content)

            setBarChatDate(barData);

            const platFormChatData = getPlatformChartData(redordsResponse.data.content)
            setPlatfomrDate(platFormChatData);

            const genderChartData = getGenderChartData(redordsResponse.data.content);
            setGenderDate(genderChartData);
        }


        getData();
    }, [])

    return (
        <div className="page-container">
            <Filters link="/records" linkText=" VER TABELA" />


            <div className="chart-container">

                <div className="top-related">

                    <h1 className="top-related-title" >
                        JOGOS MAIS VOTADOS
                    </h1>
                    <div className="games-container">

                        <Chart
                            options={barOptions}
                            type="bar"
                            width="900"
                            height="650"
                            series={[{ data: barChartData }]}
                        />
                    </div>
                </div>
                <div className="charts">
                    <div className="platform-chart">
                        <h2 className=" chart-title">
                            Plataformas
                        </h2>
                        <Chart options={{ ...pieOptions, labes: platFormData?.labels }}
                            type="donut"
                            series={platFormData?.series}
                            width="350"
                        />
                    </div>
                    <div className="gender-chart">
                        <h2 className=" chart-title">
                            Gêneros
                        </h2>

                        <Chart options={
                            { ...pieOptions, labes: genderData?.labels }
                        }
                            type="donut"
                            series={genderData?.series}
                            width="350"
                        />
                    </div>
                </div>
            </div>
        </div>
    )

}
export default Charts;