<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row justify-content-center p-5">
            <form action="#" class="myform col-md-6 p-3">
                <div class="row">
                    <div class="form-group col-md-12 text-center">
                        <img src="media/images/mobile.jpg" alt="" height="100px">
                        <h3 class="text-primary">Product Update</h3>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-md-6 form-group">
                        <label for="product_name">Product Name</label>
                        <input type="text" class="form-control" id="product_name">
                    </div>

                    <div class="col-md-6 form-group">
                        <label for="product_type">Product Type</label>
                        <select name="" id="product_type" class="form-control">
                            <option value="mobile">Mobile</option>
                            <option value="camera">Camera</option>
                            <option value="tv">TV</option>
                            <option value="laptop">Laptop</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="product_desc">Product Description</label>
                    <textarea name="" id="product_desc" class="form-control"></textarea>
                </div>

                <div class="row mt-3">
                    <div class="form-group col-md-6">
                        <label for="unit_price">Unit Price</label>
                        <input type="number" class="form-control" placeholder="Enter product units" id="unit_price">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="stock-quantity">Stock Quantity</label>
                        <input type="text" class="form-control" placeholder="Enter product quantity" id="stock-quantity">
                    </div>
                </div>

                <div class="row text-center mt-3 mb-3">
                    <div class="col-md-6">
                        <button type="reset" class="btn btn-danger">Reset</button>
                    </div>

                    <div class="col-md-6">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<jsp:include page="footer.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>