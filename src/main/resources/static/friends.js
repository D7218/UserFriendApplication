document.addEventListener("DOMContentLoaded", function () {

    // =========================
    // DELETE CONFIRMATION
    // =========================

    const deleteForms =
        document.querySelectorAll(".delete-form");


    deleteForms.forEach(function (form) {

        form.addEventListener(
            "submit",
            function (event) {

                const confirmed = confirm(
                    "Are you sure you want to delete this friend?"
                );

                if (!confirmed) {
                    event.preventDefault();
                }

            }
        );

    });


    // =========================
    // SEARCH FRIENDS
    // =========================

    const searchInput =
        document.getElementById("searchInput");


    if (searchInput) {

        searchInput.addEventListener(
            "keyup",
            function () {

                const searchValue =
                    searchInput.value
                        .toLowerCase()
                        .trim();


                const rows =
                    document.querySelectorAll(
                        "#friendsTable tbody tr"
                    );


                rows.forEach(function (row) {


                    // Skip empty state row

                    if (row.querySelector(".empty-state")) {
                        return;
                    }


                    const name =
                        row.children[1]
                            .textContent
                            .toLowerCase();


                    const email =
                        row.children[2]
                            .textContent
                            .toLowerCase();


                    // Search by name or email

                    if (
                        name.includes(searchValue) ||
                        email.includes(searchValue)
                    ) {

                        row.style.display = "";

                    } else {

                        row.style.display = "none";

                    }

                });

            }
        );

    }

});