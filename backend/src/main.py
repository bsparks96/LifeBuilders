from fastapi import FastAPI
from utils.database import Base, engine
from models import models
from routes import user_routes
app = FastAPI()
Base.metadata.create_all(bind=engine)

app.include_router(user_routes.router, prefix="/api")




@app.get("/")
def root():
    return {"message": "LifeBuilders API is live!"}