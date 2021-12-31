class App {

    static DOMAIN = location.origin;

    static BASE_URL_PRODUCT = this.DOMAIN + "/api/products";

    static BASE_URL_CLOUD_IMAGE = "https://res.cloudinary.com/toanphat/image/upload";
    static BASE_URL_CLOUD_VIDEO = "https://res.cloudinary.com/toanphat/video/upload";
    static BASE_SCALE_IMAGE = "c_limit,w_150,h_100,q_100";

    static ERROR_400 = "Giao dịch không thành công, vui lòng kiểm tra lại dữ liệu.";
    static ERROR_403 = "Access Denied! You are not authorized to perform this function.";
    static ERROR_404 = "An error occurred. Please try again later!";
    static ERROR_500 = "Lưu dữ liệu không thành công, vui lòng liên hệ quản trị hệ thống.";
    static SUCCESS_CREATED = "Successful data generation !";
    static SUCCESS_UPDATED = "Data update successful !";
    static SUCCESS_DELETED = "Delete product successfully !";

    static showDeleteConfirmDialog() {
        return Swal.fire({
            icon: 'warning',
            text: 'Are you sure to delete the selected product ?',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, please delete this client !',
            cancelButtonText: 'Cancel',
        })
    }

    static showSuccessAlert(t) {
        Swal.fire({
            icon: 'success',
            title: t,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500
        })
    }

    static showErrorAlert(t) {
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: t,
        })
    }
}


class Product {
    constructor(id, name, description, fileId, fileName, fileFolder, fileType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileFolder = fileFolder;
        this.fileType = fileType;
    }
}