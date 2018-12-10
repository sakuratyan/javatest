package com.testraytrace;

/**
 * BMP
 */
// public class BMP {

	
// 	// 文件体

// 	// 构造

// 	// method
// }


class BMPHEADER{
	/* 位图文件头 */
	short bfType = 0x4d42;// 文件格式
	int bfSize;// 文件大小 unsigned
	short bfReserved1;// 保留 unsigned
	short bfReserved2;// 保留 unsigned
	int bfOffBits;// 数据偏移量 unsigned

	/* 位图信息头 */
	int biSize = 14;// BITMAPINFOHEADER结构所需要的字数 unsigned
	int biWidth;// 图像宽度，像素为单位
	int biHeight;// 图像高度，像素为单位，为正数，图像是倒序的，为负数，图像是正序的
	short biPlanes = 1;// 为目标设备说明颜色平面数，总被置为1 unsigned
	short biBitCount = 24;// 说明比特数/像素 unsigned
	int biCompression = 0;// 说明数据压缩类型 unsigned
	int biSizeImage;// 说明图像大小，字节单位 unsigned
	int biXPixPerMeter;// 水平分辨率，像素/米
	int biYPixPerMeter;// 垂直分辨率
	int biClrUsed;// 颜色索引数 unsigned
	int biClrImportant;// 重要颜色索引数，为0表示都重要 unsigned

	/* 调色板结构 */
	char rgbBlue;// 蓝色分亮度 unsigned
	char rgbGreen;// 绿色分亮度 unsigned
	char rgbRed;// 红色分亮度 unsigned
	char rgbReserved; // unsigned

	
}